const Car = require('../models/Car');

module.exports.addGet = (req, res) => {
    res.render('cars/create');
}

module.exports.addPost = (req, res) => {
    let car = req.body;
    car.creator = req.user._id;

    Car.create(car).then(() => {
        Car.find({renter:null}).then((cars) => {
            res.render('cars/all', { cars,carAdded:true });
        })
    })
}

module.exports.viewAll = (req, res) => {
    let canEdit = true;

    Car.find({renter:null}).then((cars) => {
        res.render('cars/all', { cars, canEdit });
    })
}

module.exports.editGet = (req, res) => {
    let carId = req.params.id;

    Car.findById(carId).then((car) => {
        res.render('cars/edit', { car });
    })
}

module.exports.editPost = (req, res) => {
    let carId = req.params.id;
    let updatedCar = req.body;
    updatedCar.creator = req.user._id;

    Car.findByIdAndUpdate(carId, updatedCar).then(() => {
        Car.find({renter:null}).then((cars) => {
            res.render('cars/all', { cars });
        })
    })
}

module.exports.rentGet = (req, res) => {
    res.render('cars/rent');
}

module.exports.rentPost = (req, res) => {
    let carId = req.params.id;

    Car.findById(carId).then((car) => {
        car.renter = req.user.id;
        car.duration = req.body.duration;

        car.save().then(() => {
            res.redirect('/');
        })
    })
}

module.exports.getProfile = (req, res) => {
    let userId = req.user.id;
    let username = req.user.username;

    Car.find({ renter: userId }).then((rentedCars) => {
        res.render('users/profile', { username, rentedCars });
    })
}

module.exports.searchByMake = (req, res) => {
    let make = req.body.make;

    Car.find({make:make,renter:null}).then((cars)=>{
        res.render('cars/all', { cars });
    })
}