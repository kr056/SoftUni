function getMelons(){
    let test1 : Watermelon = new Watermelon(50,'GodSize');
    let test5: Melonmelon = new Melonmelon(30,'Unknown');
    let test2 : Airmelon = new Airmelon(25,'KingSize');
    let test3 : Firemelon = new Firemelon(50,'Giant');
    let test4 : Earthmelon = new Earthmelon(50,'Hobbit');

    test5.morph();
    test5.morph();

    console.log(test1.toString());
    console.log(test2.toString());
    console.log(test3.toString());
    console.log(test4.toString());
    console.log(test5.toString());
}
getMelons()