// add pageTitle
const pageTitle = 'My Shopping List'
// add groceries
const groceries = [
  'Bottle of mustard','fertilized emu egg','bread','oats','modelo','butter','condoms','plan b pills','pokemon cards','insurance'
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const updatePageTitle = document.getElementById('title');
  updatePageTitle.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const addGroceriesToList = document.getElementById('groceries');
  groceries.forEach(grocery =>{
    const groceryHolder = document.createElement('li');
    groceryHolder.innerText = grocery;
    addGroceriesToList.insertAdjacentElement('beforeend', groceryHolder);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
