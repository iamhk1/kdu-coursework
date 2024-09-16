player = {
  firstName: "Leo",

  lastName: "Messi",

  address: {
    country: "Spain",

    city: "Barcelona",
  },

  careerInfo: {
    fcBarcelona: {
      appearances: 780,

      goals: {
        premierLeagueGoals: 590,

        championsLeagueGoals: 50,
      },
    },
  },
};
let allKeys = [];
let allValues = [];

function printKeys(obj) {
  for (let key in obj) {
    if (typeof obj[key] === "object" && obj[key] !== null) {
      printKeys(obj[key]);
    } else {
      allKeys.push(key);
    }
  }
}

function printValues(obj) {
  for (let key in obj) {
    if (typeof obj[key] === "object" && obj[key] !== null) {
      printValues(obj[key]);
    } else {
      allValues.push(obj[key]);
    }
  }
}

printKeys(player);
printValues(player);
console.log("Keys");
console.log(allKeys);
console.log("Values");
console.log(allValues);
