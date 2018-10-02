const Image = require('mongoose').model('Image');
const Tag = require('mongoose').model('Tag');
const fs = require('fs');

module.exports = (req, res) => {
  if (req.pathname === '/search') {
    fs.readFile('./views/results.html', 'utf-8', (err, html) => {

      if (err) {
        throw err;
      }

      const params = {};

      let beforeDate = req.pathquery.beforeDate ? req.pathquery.beforeDate : Date.now();
      let afterDate = req.pathquery.afterDate ? req.pathquery.afterDate : new Date(0, 0, 0);
      let limit = req.pathquery.Limit ? Number(req.pathquery.Limit) : 10;
      const tags = req.pathquery.tagName.split(',').filter(e => e !== '');

      if (tags.length > 0) {
        Tag.find({ name: { $in: tags } }).then(data => {
          const tagIds = data.map(m => m._id);
          params.tags = tagIds;
          getImagesAndRespond(params);
        })
      } else {
        getImagesAndRespond(params);
      }

      function getImagesAndRespond(params) {
        Image.find(params)
          .where('creationDate')
          .gt(afterDate)
          .lt(beforeDate)
          .sort({ creationDate: -1 })
          .limit(limit)
          .then(data => {

            let imageHtml = '';

            for (let image of data) {
              imageHtml += imageTemplate(image);
            }

            html = html.replace('<div class="replaceMe"></div>', imageHtml);

            res.writeHead(200, {
              'content-type': 'text/html'
            })

            res.write(html);
            res.end();
          })
      }
    })
  } else {
    return true;
  }
}


function imageTemplate(image) {
  return `<fieldset id ="${image._id}">
  <img src="${image.url}">
  </img><p>${image.description}<p/>
  <button onclick='location.href="/delete?id=${image._id}"'class='deleteBtn'>Delete
  </button> 
  </fieldset>`
    ;
}