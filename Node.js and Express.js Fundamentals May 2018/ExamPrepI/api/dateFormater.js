function formatDate(date){
    let dateStr = date.toISOString();
    dateStr=dateStr.substring(0,24);
    return dateStr;
}

module.exports = {
    formatDate
}