let uuid=require("uuid")
let users=[
    {
        "id": uuid.v4(),
        "name":"Manav Verma",
        "user_name": "manav_verma",
        "user_email_id": "manavverma@gmail.com",
        "password": "m123",
        "profile_url": "https://img.freepik.com/free-vector/handsome-man_1308-85984.jpg?size=626&ext=jpg"
    },
    
        {
            "id": uuid.v4(),
            "name":"Asish Mohapatra",
            "user_name": "asish_mohapatra",
            "user_email_id": "asish@gmail.com",
            "password": "asish123",
            "profile_url": "https://img.freepik.com/free-vector/man-wearing-glasses-smiling-head_1308-153387.jpg?size=626&ext=jpg"
        },
        {
            "id":uuid.v4(),
            "name":"Harsh Kachhawa",
            "user_name":"harsh_k",
            "user_email_id":"harsh@gmail.com",
            "password":"harsh123",
            "profile_url":"https://img.freepik.com/free-vector/happy-middle-age-man-cartoon-head_1308-134364.jpg?size=626&ext=jpg&ga=GA1.1.1496103667.1708240761&semt=ais"
        }
      
]
module.exports=users