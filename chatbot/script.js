// function getBotResponse(message) {

//     message = message.toLowerCase();

//     if (message.includes("hello") || message.includes("hi")) {
//         return "Hello! Welcome to Customer Support.";
//     }

//     else if (message.includes("product")) {
//         return "We offer laptops, mobiles, and accessories.";
//     }

//     else if (message.includes("order")) {
//         return "Please provide your Order ID.";
//     }

//     else if (message.includes("delivery")) {
//         return "Delivery takes 3-5 business days.";
//     }

//     else if (message.includes("refund") || message.includes("return")) {
//         return "Refunds are processed within 7 working days.";
//     }

//     else if (message.includes("payment")) {
//         return "We accept UPI, Debit Card, and Credit Card.";
//     }

//     else if (message.includes("contact")) {
//         return "You can contact us at support@gmail.com";
//     }

//     else if (message.includes("bye")) {
//         return "Thank you for visiting!";
//     }

//     else {
//         return "Sorry, I didn't understand.";
//     }
// }

// function sendMessage() {

//     let inputField = document.getElementById("userInput");
//     let message = inputField.value;

//     if (message.trim() === "") {
//         return;
//     }

//     let chatBox = document.getElementById("chatBox");

//     // User message
//     chatBox.innerHTML += `<div class="user"><b>You:</b> ${message}</div>`;

//     // Bot response
//     let response = getBotResponse(message);

//     chatBox.innerHTML += `<div class="bot"><b>Bot:</b> ${response}</div>`;

//     inputField.value = "";

//     chatBox.scrollTop = chatBox.scrollHeight;
// }

const intents = {

    greeting: {
        keywords: ["hello", "hi", "hey"],
        response: "Welcome to Hotel Paradise. How can I help you?"
    },

    room_availability: {
        keywords: ["room available", "availability", "need a room"],
        response: "Yes, rooms are available today."
    },

    room_types: {
        keywords: ["room types", "room price", "room cost"],
        response:
            "Room Types:<br>" +
            "Single Room ₹2000/night<br>" +
            "Double Room ₹3500/night<br>" +
            "Deluxe Room ₹5000/night"
    },

    menu: {
        keywords: ["menu", "food menu"],
        response:
            "Menu Categories:<br>" +
            "Starters<br>Main Course<br>Desserts<br>Beverages"
    },

    facilities: {
        keywords: ["facilities", "services"],
        response:
            "Facilities include Wi-Fi, Swimming Pool, Gym, Parking."
    }
};

function detectIntent(message){

    message = message.toLowerCase();

    for(let intent in intents){

        let data = intents[intent];

        for(let keyword of data.keywords){

            if(message.includes(keyword)){
                return data.response;
            }
        }
    }

    return "Sorry, I didn't understand.";
}

function send(){

    let msg = document.getElementById("msg").value;

    if(msg.trim() === ""){
        return;
    }

    let chat = document.getElementById("chat");

    chat.innerHTML +=
        `<div class="user">${msg}</div>`;

    let reply = detectIntent(msg);

    chat.innerHTML +=
        `<div class="bot">${reply}</div>`;

    document.getElementById("msg").value = "";

    chat.scrollTop = chat.scrollHeight;
}