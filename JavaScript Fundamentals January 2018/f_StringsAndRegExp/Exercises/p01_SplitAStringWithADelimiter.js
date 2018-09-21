function splitString(str, delimiter) {
    return str.split(delimiter).forEach(x => console.log(x));
}
splitString('One-Two-Three', '-')