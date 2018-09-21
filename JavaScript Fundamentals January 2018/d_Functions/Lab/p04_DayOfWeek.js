function dayOfWeek(day) {
    let week = ['Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday'];
    let found = false;

    for (let i = 0; i < 7; i++) {
        if(day===week[i]){
            console.log(i+1);
            found=true;
            return;
        }
    }
    
    if(!found){
        console.log('error');
    }
}
dayOfWeek('Saturday');