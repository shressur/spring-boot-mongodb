<h3>MongoDB</h3>
<pre>
  - MongoDB is open-source
  - MongoDB is NoSQL database written C++
  - Supported data types: most common data types are string, integer, boolean, double, arrays, timestamp, objects, null, date, binary data, 
        code (store JavaScript codes in document), regular expressions
  <table>
      <tr>
        <th>MongoDB</th>
        <th>Cassandra</th>
      <tr>
        <td>Developed by MongoDB Inc</td>
        <td>Developed in Facebook and later abandoned. Apache software foundation now maintains it</td>
      </tr>
      <tr>
        <td>Written C++</td>
        <td>Written in Java</td>
      </tr>
      <tr>
          <td>Comparatively slower than Cassandra</td>
          <td>Comparatively faster than MongoDB</td>
    </tr>
    <tr>
        <td>Supports "secondary indexes"</td>
        <td>No "secondary indexes"</td>
    </tr>
    <tr>
        <td>Supports JSON and BSON data</td>
        <td>Supports JSON only</td>
    </tr>
    <tr>
        <td>No support for ACID transaction</td>
        <td>Supports ACID transactions</td>
    </tr>
  </table>
  * ACID: Atomicity, Consistency, Isolation, and Durability. All or nothing type transaction.
</pre>
<pre>
    <table>
        <tr>
            <th>RDBMS</th>
            <th>MongoDB</th>
        </tr>
        <tr>
            <td>Database</td>
            <td>Database</td>
        </tr>
        <tr>
            <td>Table</td>
            <td>Collection</td>
        </tr>
        <tr>
            <td>Row</td>
            <td>Document</td>
        </tr>
        <tr>
            <td>Column</td>
            <td>Field</td>
        </tr>
        <tr>
            <td>Multiple "tables" and "join tables" are used to structure data</td>
            <td>Everything is put in a single "collection"</td>
        </tr>
        <tr>
            <td>Good for relational data</td>
            <td>Good for unstructured data</td>
        </tr>
    </table>
</pre>
<pre>
    <table>
        <tr>
            <th>Command</th>
            <th>Description</th>
        </tr>
        <tr>
            <td>db.help()</td>
            <td>Help</td>
        </tr>
        <tr>
            <td>use your_database_name</td>
            <td>Switch to or use provided database to run commands/query against. If database does not exits, it will create one. 
                    Example: use test_db</td>
        </tr>
        <tr>
            <td>show dbs</td>
            <td>List all databases. You can also run "show databases".</td>
        </tr>
        <tr>
            <td>db</td>
            <td>Shows name of current database</td>
        </tr>
        <tr>
            <td>db.dropDatabase()</td>
            <td>Deletes current/selected database (run "use my_db_name" first)</td>
        </tr>
        <tr>
            <td>db.your_collection_name.drop()</td>
            <td>Delete specified collection</td>
        </tr>
        <tr>
            <td>db.your_collection_name.deleteOne(selection_criteria)</td>
            <td>Deletes specific document. Example:
                
            </td>
        </tr>
        <tr>
            <td>db.your_collection_name.deleteMany(selection_criteria)</td>
            <td>Same as .deleteOne() but deletes all matching documents</td>
        </tr>
        <tr>
            <td>db.createCollection(name, &lt;options&gt;)</td>
            <td>Creates collection. Example: db.createCollection("employee_attendance"). Options are optional => "capped": fixed size (true/false),
                "autoIndexId": auto create IDs (true/false),
                "size": max size of capped collection in bytes. When max size is reached old data are overwritten,
                "max": a number indicating max number of documents allowed</td>
        </tr>
        <tr>
            <td>db.your_collection_name.insertOne(document)</td>
            <td>Insert new document in the collection. 
                Example:
                db.employees.insert({
                    name: "John", 
                    age: 34, 
                    skills: ['c++', 'Java'], 
                    address: {
                        street: "111 One St", 
                        city: "Cool City", 
                        state: "CT"
                    }
                })</td>
        </tr>
        <tr>
            <td>db.your_collection_name.insertMany(document)</td>
            <td>Inserts multiple new documents in the collection.
                Example:
                db.employees.insertMany(
                [{
                    name: "James", 
                    age: 24, 
                    skills: ['C++', 'Java'], 
                    address: {
                        street: "123 Main St", 
                        city: "Big City", 
                        state: "BT"
                    }
                },
                {
                    name: "Bond", 
                    age: 35, 
                    skills: ['Python', 'C#', 'Java'], 
                    address: {
                        street: "345 Straight Dr", 
                        city: "Small City", 
                        state: "ST"
                    }
                }]) 
                </td>
        </tr>
        <tr>
            <td>db.your_collection_name.find()</td>
            <td>Finds all documents. Example:
                db.employees.find()
            </td>
        </tr>
        <tr>
            <td>db.your_collection_name.find(selection_criteria)</td>
            <td>Finds specific document matching passed filter criteria. Example:
                db.employees.find({first_name: "James"})
            </td>
        </tr>
        <tr>
            <td>db.your_collection_name.limit(number)</td>
            <td>Query and display certain numbers of documents. Example:
                db.employees.find().limit(2)
            </td>
        </tr>
        <tr>
            <td>db.your_document_name.find().sort({field:1})</td>
            <td>Sorting query results. "1" => Ascending order, "-1" => Descending order. Exmaple:
                db.employees.find().sort({name:-1})
            </td>
        </tr>
        <tr>
            <td>db.your_collection_name.updateOne(selection_criteria, new_val)</td>
            <td>Update a particular document. Example:
                db.employees.find({name:"James"},{$set:['PHP','Ruby', 'ASP.NET']})
            </td>
        </tr>
        <tr>
            <td>$in</td>
            <td>Search/Filter documents query with an array. Example:
                db.employees.updateMany({
                    skills:{ $in: ['Java', 'Ruby']} }, 
                    { $set: {"skills_matched": false}})    
            </td>
        </tr>
        <tr>
            <td>$nin</td>
            <td>Search/Filter documents query with Not-In the array criteria</td>
        </tr>
        <tr>
            <td>$ne</td>
            <td>Not-equal to. Example:
                db.employees.find({name: {$ne: "J*}})
            </td>
        </tr>
        <tr>
            <td>&lt;field&gt;: {$regex:/pattern/}. Example:
                db.employees.find({name: {$regex:/o/}}) => containing "o" in the name
                db.employees.find({name: {$regex:/^J/}}) => name starting with "J"
                db.employees.find({name: {$regex:/n$/}}) => name ending with "n"
                db.employees.find({name: {$regex:/o/}}) =>  
            </td>
        </tr>
        <tr>
            <td>$lt, $ltex, $gt, $gte</td>
            <td>Numeric comparison: $lt => less than, 
                                    $lte => less than or equal to
                                    $gt => greater than
                                    $gte => greater than or equal to
                Example: 
                    db.employees.find({ age: {$gte: 55} })
            </td>
        </tr>
        <tr>
            <td>db.your_collection_name.countDocuments()</td>
            <td>Returns a number representing the number of documents in a particular collection</td>
        </tr>
        <tr>
            <td>db.your_collection_name.countDocuments(selection_criteria)</td>
            <td>Returns a number representing the number of documents in a particular collection. Example:
                db.employees.countDocuments({skills:{$in:['Java']}})
            </td>
        </tr>
        <tr>
            <td>mongodump</td>
            <td>mongodump: create a backup. Read more: https://www.mongodb.com/docs/database-tools/mongodump/</td>
        </tr>
        <tr>
            <td>shard</td>
            <td>shard: create a backup. Read more: https://www.mongodb.com/docs/manual/sharding/</td>
        </tr>
        <tr>
            <td>db.createUser({user:user_name, pwd: secret_password, roles: ["readWrite", "dbAdmin"], db: "admin"})</td>
            <td>Creates database user with specified provided options. Roles: readWrite, clusterAdmin, dbAdmin, readAnyDatabase. You can 
            use "use admin" and leave out "db:'admin'".</td>
        </tr>
        <tr>
            <td>db.getUsers()</td>
            <td>List all users</td>
        </tr>
        <tr>
            <td>db.changeUserPassword(user_name, new_password)</td>
            <td>Change specific user password. Exmaple: 
                db.changeUserPassword("cat101","grumpycat9")
            </td>
        </tr>
        <tr>
            <td>db.dropUser(user_name)</td>
            <td>Remove a specific user. Example:
                db.dropUser("cat101")
            </td>
        </tr>
    </table>
</pre>
<pre>
    Install MongoDB in MacOSX:
    Run following commands in terminal:
        brew tap mongodb/brew    
        brew install mongodb-community

    Start MongoDB server:
        mongod --config /usr/local/etc/mongod.conf
    Use MongoDB Compass or separate terminal to interact with database

    Stop server: 
        Ctrl + C

    Uninstall MongoDB:
        brew untap mongodb/brew    
        brew uninstall mongodb-community
        more: https://www.mongodb.com/basics/uninstall-mongodb
</pre>
<pre>
    Default database path on MacOSX: 
        /usr/local/var/mongodb
</pre>
<pre>
    You can do this:
    -----------------
    @RequestParam(value="paramOne", required=true)
    @RequestParam(name="paramOne", required=true)
    @RequestParam(value="paramOne", required=true, name="paramOne")
    
    But not this:
    --------------
    @RequestParam(value="paramOne", required=true, name="paramNotOne")
</pre>
<pre>
    repository.save() => overwrites existing data/document
    wrestlerRepository.insert() => adds new data/document
</pre>
<pre>
    Test API with Postman
    1. CREATE:
        POST: localhost:8080/new-wrestler
        {
            "name":"Trish Stratus",
            "finisher": "Springboard Bulldog",
            "isActive":false,
            "gender":"Female"
        }
        POST: localhost:8080/new-wrestler-many
        [{
            "name":"Goldberg",
            "finisher": "Jack Hammer",
            "isActive":false,
            "gender":"Male"
        },
        {
            "name":"The Rock",
            "finisher": "The Rock Bottom",
            "isActive":false,
            "gender":"Male"
        }]
    2. READ
        GET: localhost:8080/view-wrestlers
        GET: localhost:8080/view-wrestler
            param => id     &lt;generated_id&gt;
    3. UPDATE
        PUT: localhost:8080/update-wrestler
        {
            "id":"<generated_id>",
            "name":"John Cena",
            "finisher": "AA",
            "isActive":true,
            "gender":"Male"
        }
    4. DELETE
        DELETE: localhost:8080/delete-wrestler
            param => id     &lt;generated_id&gt;
</pre>