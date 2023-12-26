db.createUser({
  user: "adminUser",
  pwd: "password",
  roles: ["userAdminAnyDatabase", "dbAdminAnyDatabase"],
});

db.students.insertMany([
  { name: "Rajdeep", age: 11 },
  { name: "Soumyadeep", age: 23 },
  { name: "Bharati", age: 23 },
  { name: "Ranadeep", age: 33 },
  { name: "Sirsendu", age: 23 },
  { name: "Debjani", age: 27 },
  { name: "Deblina", age: 28 },
  { name: "Rajdeep", age: 28 },
  { name: "Somnath", age: 34 },

  { name: "Debendra Nath", age: 65 },
  { name: "Tapasi", age: 55 },
  { name: "Shila", age: 50 },
  { name: "Sarajit", age: 55 },
  { name: "Bishwanath", age: 67 },
  { name: "Pihu", age: 1 },
  { name: "Shanu", age: 3 },
  { name: "Tiya", age: 2 },
  { name: "Mampu", age: 15 },
  { name: "Subhodeep", age: 26 },
]);

db.createCollection("nonFiction", {
  validator: {
    $jsonSchema: {
      required: ["name", "price"],
      properties: {
        name: {
          bsonType: "string",
          description: "must be a string",
        },
        price: {
          bsonType: "number",
          description: "must be a number",
        },
      },
    },
  },
  validationAction: "warn",
});

db.runCommand({
  collMod: "nonFiction",
  validator: {
    $jsonSchema: {
      required: ["name", "price", "author"],
      properties: {
        name: {
          bsonType: "string",
          description: "must be a string",
        },
        price: {
          bsonType: "number",
          description: "must be a number",
        },
        author: {
          bsonType: "array",
          description: "must be an array",
          items: {
            bsonType: "object",
            required: ["name", "date"],
            properties: {
              name: {
                bsonType: "string",
                description: "must be a string",
              },
              date: {
                bsonType: "date",
                description: "must be a date",
              },
            },
          },
        },
      },
    },
  },
  validationAction: "warn",
});
