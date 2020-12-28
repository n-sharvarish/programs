class Car {

    constructor(public position: number, protected speed: number) {
    }

    move() {
        this.position += this.speed;
    }
}

class SelfDrivingCar extends Car {

    constructor(position: number, speed: number, public startAutoPilot: boolean) {

        super(position, speed);
        if (startAutoPilot) {
            this.move();
        }
    }

    move() {

        super.move();
        super.move();

        console.log(this.position);
    }
}

let selfCar = new SelfDrivingCar(0, 42, true);
console.log(selfCar.position);