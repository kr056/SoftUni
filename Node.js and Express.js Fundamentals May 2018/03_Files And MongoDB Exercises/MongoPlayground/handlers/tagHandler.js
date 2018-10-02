const formidable = require('formidable');
const Tag = require('mongoose').model('Tag');
module.exports = (req, res) => {
  if (req.pathname === '/generateTag' && req.method === 'POST') {

    let form = new formidable.IncomingForm();

    form.parse(req, (err, fields, files) => {

      if (err) {
        console.log(err);
        return;
      }

      const name = fields.tagName;

      Tag.create({
        name,
        images: []
      }).then(() => {

        res.writeHead(302, {
          Location: '/'
        });

        res.end();
      });
    })

  } else {
    return true;
  }
}
