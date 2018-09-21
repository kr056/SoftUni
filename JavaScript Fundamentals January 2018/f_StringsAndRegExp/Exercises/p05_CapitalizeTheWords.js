function capitalizeTheWords(str) {
    let result = [];

    str.split(' ').map(s => result.push(s[0].toUpperCase() + s.substring(1).toLowerCase()));

    console.log(result.join(' '));
}
capitalizeTheWords('Was that Easy? tRY thIs onE for SiZe!')