function getFoodType(name) {
    if (name === "banana" || name === "apple" || name === "kiwi"
        || name === "cherry" || name === "lemon"
        || name === "grapes" || name === "peach") {
        console.log("fruit");
    } else if (name === "tomato" || name === "cucumber" || name === "pepper"
        || name === "onion" || name === "garlic"
        || name === "parsley") {
        console.log("vegetable");
    } else {
        console.log("unknown");
    }
}

getFoodType("apple")