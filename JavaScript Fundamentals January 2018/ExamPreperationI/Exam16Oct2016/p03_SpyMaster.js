function spyMaster(arr) {
    let key = arr.shift();
    let pat = "(\\s|^)";

    for (let i = 0; i < key.length; i++) {
        pat += "[" + key[i].toLowerCase() + key.toUpperCase() + "]";
    }

    pat += "\\[ ]+([A-Z!$#%]{8,})( |\\.|,|$)";
    let pattern = new RegExp(pat, "g");

    for (let i = 0; i < arr.length; i++) {
        let m;

        while (m = pattern.exec(arr[i])) {
            arr[i] = arr[i].replace(m[2], updateStr(m[2]))
        }
    }
    console.log(arr.join('\n'));

    function updateStr(m) {
        m = m.replace(/\!/g, (x) => '1')
        m = m.replace(/\%/g, (x) => '2')
        m = m.replace(/\#/g, (x) => '3')
        m = m.replace(/\$/g, (x) => '4')
        m = m.replace(/[A-Z]/g, (x) => x.toLowerCase())
        return m;
    }
}

spyMaster(["hiddenTrap",
    "Now the ultimate hiddenTrap HIDDENTR just some text",
    "who said the message couldn't be contained in the key",
    "or it could be this HIDDENTRAP, HIDDENTRAP HIDDENTRA",
    "some more tests this one is wrong (HIDDENTRAP HIDDENTRA)",
    "now with some spaces HIDDENTRAP         HIDDENTRA  HIDDENTRAP  HIDDENTR",
    "hiddenTrap HiddenTRA, hiddenTrap HIDDENTRA"]
)
//
// spyMaster(["secret",
//     "Random text with secrets EVERYWHERE",
//     "secret HEREHERE and one secret OVERTHEREANDEVERYWHERE",
//     "secret SECRETTIME, and secret KINDATHERE.",
//     "secret ONELINER",
//     "and maybe secret FALSESE or secret TRUESECRET or secret ENDONCOMA,",
//     "here are three secrets one secret OVERHERE, one secret OVERTHERE and one secret DISSAPPOINT"])