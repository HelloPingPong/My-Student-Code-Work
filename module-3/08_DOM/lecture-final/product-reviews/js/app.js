const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {

  /*
    Select div with the id main (parent)
    loop over the reviews
      for each review in the array
        create a new div (reviewDiv) with the class review
          create a h4 with the reviews name and the reviewDiv as the parent
          create a div with the class rating and the reviewDiv as the parent 
            for each rating create an img/star.png with the parent for the rating div
          create an h3 with the review title and the reviewDiv as the parent
          create a p with the review text and the reviewDiv as the parent
        Attach the reviewDiv to the div#main as a child
  */

  const main = document.getElementById('main');
  reviews.forEach( review => {
      // Create a new div
      const reviewContainer = document.createElement('div');
      // Add the review class to the new div
      reviewContainer.classList.add('review');

      // Add Reviewer
      addReviewer(reviewContainer, review.reviewer);

      // Add the Rating
      addRating(reviewContainer, review.rating);

      // Add the Review Title
      addTitle(reviewContainer, review.title);
      
      // Add Review
      addReview(reviewContainer, review.review);

      // Append it as a child of the main
      main.insertAdjacentElement('beforeend', reviewContainer);
  });

}

function changeBorderOfEveryOtherReview() {
  const everyOtherDiv = document.querySelectorAll('div#main div:nth-child(even)');
  const divsAsArray = Array.from(everyOtherDiv);
  const onlyReviewDivs = divsAsArray.filter( div => {
    return div.classList.contains('review');
  });
  onlyReviewDivs.forEach(review => {
    review.classList.add('blueborder');
  });
}

/**
 * I will create a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  // Create an h4
  const reviewer = document.createElement('h4');
  // set the text to the reviewer
  reviewer.innerText = name;
  // attach it to the parent container
  parent.appendChild(reviewer);
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  // Create a new div class rating
  const ratingDiv = document.createElement('div');
  ratingDiv.classList.add('rating');
  // create 1 star for each rating with the class rating star
  // append the stars to the new rating div
  for (let i = 0; i < numberOfStars; i++) {
    const starImg = document.createElement('img');
    starImg.src = 'img/star.png';
    starImg.classList.add('ratingStar');
    ratingDiv.appendChild(starImg);
  }
  // append the rating div to the parent
  parent.appendChild(ratingDiv);
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const titleh3 = document.createElement('h3');
  titleh3.innerText = title;
  parent.appendChild(titleh3);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const reviewP = document.createElement('p');
  reviewP.innerText = review;
  parent.appendChild(reviewP);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();

changeBorderOfEveryOtherReview();
