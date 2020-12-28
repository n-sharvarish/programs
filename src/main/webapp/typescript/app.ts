class App {

    constructor() {
    }

    public static PI: number = 3.14;

    fruits: any[] = [
        {name: 'apples', quantity: 2},
        {name: 'bananas', quantity: 0},
        {name: 'cherries', quantity: 5}
    ];
}

let app = new App();
console.log(app.fruits.find(f => f.name === "apples"));
console.log(App.PI);