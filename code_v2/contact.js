import wixData from 'wix-data';
import {fetch} from 'wix-fetch';


// Velo API Reference: https://www.wix.com/velo/reference/api-overview/introduction

$w.onReady(function () {

	// Call functions on page elements, e.g.:
	// $w("#button1").label = "Click me!";

});

/**
*	Adds an event handler that runs when the element is clicked.
	[Read more](https://www.wix.com/corvid/reference/$w.ClickableMixin.html#onClick)
*	 @param {$w.MouseEvent} event
*/
export function button1_click(event) {
	// This function was added from the Properties & Events panel. To learn more, visit http://wix.to/UcBnC-4
	// Add your code for this event here: 
	let name = $w("#input3").value;
	let email = $w("#input2").value;
	let subject = $w("#input1").value;
	let message = $w("#textBox1").value;
    
	let dbEntry = {
		name: name,
		email: email,
		subject: subject,
		message: message,
	};
	wixData.insert("ContactUsSubmissions", dbEntry);

	let params = {
      user_id: '***',
      service_id: '***',
      template_id: '***',
      template_params: {
        'YOUR_PARAM1_NAME': 'YOUR_PARAM1_VALUE',
        'YOUR_PARAM2_NAME': 'YOUR_PARAM2_VALUE'
      }
  };

  let headers = {
      'Content-type': 'application/json'
  };

  let options = {
      method: 'POST',
      headers: headers,
      body: JSON.stringify(params)
  };

  fetch('https://api.emailjs.com/api/v1.0/email/send', options)
    .then((httpResponse) => {
        if (httpResponse.ok) {
            console.log('Your mail is sent!');
        } else {
            return httpResponse.text()
              .then(text => Promise.reject(text));
        }
    })
    .catch((error) => {
        console.log('Oops... ' + error);
    });
}