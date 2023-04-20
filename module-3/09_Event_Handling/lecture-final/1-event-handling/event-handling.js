const clickedText = "You did it!  You clicked the Shinny Red Button!!";


document.addEventListener('DOMContentLoaded', ()=> {

    document.querySelector('input.redbutton').addEventListener('click', (event)=> {
        alert(clickedText);
        console.log(event);
   });

});

