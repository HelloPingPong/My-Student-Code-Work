package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		//use int, double, boolean, char, long. Define your variables. Pass iso test//
		int raccoonsPlayingInWoods = 3;
		int raccoonsWhoLeave = 2;
		int raccoonsRemainingInWoods = raccoonsPlayingInWoods - raccoonsWhoLeave;
		System.out.println(raccoonsRemainingInWoods);
        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int flowersInNeedOfPollination = 5;
		int beesAvailableToPollinate = 3;
		int flowersThatWontGetPollinatedForLackOfBees = flowersInNeedOfPollination - beesAvailableToPollinate;
		System.out.println(flowersThatWontGetPollinatedForLackOfBees);

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int pigeonsOriginallyGorgingThemselvesOnBreadcrumbs = 1;
		int pigeonsEnticedFromADistanceByTheSmellOfBread = 1;
		int amountOfPigeonsNoLongerSufferingFromMalnutrition = pigeonsOriginallyGorgingThemselvesOnBreadcrumbs + pigeonsEnticedFromADistanceByTheSmellOfBread;
		System.out.println(amountOfPigeonsNoLongerSufferingFromMalnutrition);

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int localOwlsEnjoyingSittingTogetherOnAFence = 3;
		int owlsWhoHaveCompletedALongJourneyToSitWithOtherOwlsOnTheFence = 2;
		int totalFenceOwlPopulation = localOwlsEnjoyingSittingTogetherOnAFence + owlsWhoHaveCompletedALongJourneyToSitWithOtherOwlsOnTheFence;
		System.out.println(totalFenceOwlPopulation);

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beaversThatAreWorkingOnTheirHomesToImproveTheirLivingConditionsInAnticipationOfBeingUnableToWorkOnItInTheFutureBecauseOfBuildingMaterialPriceIncreasesDueToInflation = 2;
		int shortSightedBeaversLackingInSelfDisciplineWhoHaveAbandonedTheirDutiesToPursueMomentaryPleasureSwimmingInThePoolAndWillInadvertentlySufferWhenThePriceOfLumberIncreases = 1;
		int responsibleBeaversWhoContinueToWorkHardOnTheirHomesWhileTheirFriendsHaveGoneSwimmingInstead = beaversThatAreWorkingOnTheirHomesToImproveTheirLivingConditionsInAnticipationOfBeingUnableToWorkOnItInTheFutureBecauseOfBuildingMaterialPriceIncreasesDueToInflation - shortSightedBeaversLackingInSelfDisciplineWhoHaveAbandonedTheirDutiesToPursueMomentaryPleasureSwimmingInThePoolAndWillInadvertentlySufferWhenThePriceOfLumberIncreases;
		System.out.println(responsibleBeaversWhoContinueToWorkHardOnTheirHomesWhileTheirFriendsHaveGoneSwimmingInstead);
        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansWhoAreAlreadySittingOnATreeLimbAndDecideToStartAClub = 2;
		int toucansWhoJoinTheSittingTreeClub = 1;
		int totalMembershipCountForTheToucansSittingInATreeClub = toucansWhoAreAlreadySittingOnATreeLimbAndDecideToStartAClub + toucansWhoJoinTheSittingTreeClub;
		System.out.println(totalMembershipCountForTheToucansSittingInATreeClub);


        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrelsLivingInTheTreeCommunity = 4;
		int nutsStoredToFeedTheTreeCommunity = 2;
		int squirrelPopulationPredictedToGoHungryInTheUpcomingNutFamine = squirrelsLivingInTheTreeCommunity - nutsStoredToFeedTheTreeCommunity;
		System.out.println(squirrelPopulationPredictedToGoHungryInTheUpcomingNutFamine);

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;
		double amountOfMoneyInCentsThatMrsHiltFoundRemainingInHerBankAccountAfterBlowingTheRestOnBadCryptoInvestments = quarter + dime + (nickel * 2);
		System.out.println(amountOfMoneyInCentsThatMrsHiltFoundRemainingInHerBankAccountAfterBlowingTheRestOnBadCryptoInvestments);

        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int briersClassMuffinCount = 18;
		int macAdamsClassMuffinCount = 20;
		int flanneryClassMuffinCount = 17;
		int amountOfMuffinsBakedByInexperiencedFirstGraders = briersClassMuffinCount + macAdamsClassMuffinCount + flanneryClassMuffinCount;
		System.out.println(amountOfMuffinsBakedByInexperiencedFirstGraders);

        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double priceOfYoYo = 0.24;
		double priceOfWhistle = 0.14;
		double moneySpentOnToys = priceOfYoYo + priceOfWhistle;
		System.out.println(moneySpentOnToys);

        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallowsUsed = largeMarshmallows + miniMarshmallows;
		System.out.println(totalMarshmallowsUsed);

        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int inchesOfSnowAtHiltsHouse = 29;
		int inchesOfSnowAtBrecknock = 17;
		int differenceOfInchesOfSnowReceivedByHilt = inchesOfSnowAtHiltsHouse - inchesOfSnowAtBrecknock;
		System.out.println(differenceOfInchesOfSnowReceivedByHilt);

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */
		double fullAmountOfPayDayLoanToFinanceAToyTruck = 3.0;
		double priceOfOverlyExpensiveArtisanPencilCase = 2.5;
		double hiltsGamblingAndRecklessSpendingFundHiddenFromHerHusband = 10.00;
		double moneyRemainingForHiltToTakeToTheCasino = hiltsGamblingAndRecklessSpendingFundHiddenFromHerHusband - (fullAmountOfPayDayLoanToFinanceAToyTruck + priceOfOverlyExpensiveArtisanPencilCase);
		System.out.println(moneyRemainingForHiltToTakeToTheCasino);

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int marblesJoshStoleAtGunPoint = 16;
		int marblesJoshLostWhileRunningFromTheDEA = 7;
		int numberOfMarblesJoshWillBringToShowAndTellInHiltsClassTomorrow = marblesJoshStoleAtGunPoint - marblesJoshLostWhileRunningFromTheDEA;
		System.out.println(numberOfMarblesJoshWillBringToShowAndTellInHiltsClassTomorrow);

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int seaShellsMeganFoundByTheSeaShore = 19;
		int seaShellsRequiredForMegansObsessiveCompulsiveDisorderSymptomsToSubside = 25;
		int amountOfSeashellsThatNeedToBeFoundQuicklyBeforeMeganHasAPanicAttack = seaShellsRequiredForMegansObsessiveCompulsiveDisorderSymptomsToSubside - seaShellsMeganFoundByTheSeaShore;
		System.out.println(amountOfSeashellsThatNeedToBeFoundQuicklyBeforeMeganHasAPanicAttack);

        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int bradsRedBalloons = 8;
		int bradsTotalBalloons = 17;
		int bradsGreenBalloons = bradsTotalBalloons - bradsRedBalloons;
		System.out.println(bradsGreenBalloons);

        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int booksOnTheShelfEarlier = 38;
		int booksAddedToTheShelf = 10;
		int booksOnTheShelfPresently = booksOnTheShelfEarlier + booksAddedToTheShelf;
		System.out.println(booksOnTheShelfPresently);


        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int legsPerBee = 6;
		int legsPossessedByAFamilyOfEightBees = legsPerBee * 8;
		System.out.println(legsPossessedByAFamilyOfEightBees);

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double inflatedCostOfASingleConeAtDairyQueen = 0.99;
		double maximumThatHiltIsWillingToSpendOnADateWithHerHusband = inflatedCostOfASingleConeAtDairyQueen * 2;
		System.out.println(maximumThatHiltIsWillingToSpendOnADateWithHerHusband);

        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int rocksRequiredToBuildHiltsWall = 125;
		int rocksAlreadyObtainedThroughIllegalArmsDeals = 64;
		int rocksHiltWillHaveToPickUpFromHerBloodDiamondMineToCompleteTheWall = rocksRequiredToBuildHiltsWall - rocksAlreadyObtainedThroughIllegalArmsDeals;
		System.out.println(rocksHiltWillHaveToPickUpFromHerBloodDiamondMineToCompleteTheWall);

        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int marblesInHiltsCollection = 38;
		int marblesHiltAnticipatesReceivingBackFromTheDoctorAfterHerERVisit = 15;
		int marblesLeftAtHiltsHomeWhenSheEnteredTheAmbulance = marblesInHiltsCollection - marblesHiltAnticipatesReceivingBackFromTheDoctorAfterHerERVisit;
		System.out.println(marblesLeftAtHiltsHomeWhenSheEnteredTheAmbulance);

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int milesToTheConcertVenue = 78;
		int milesDrivenUntilHiltStoppedAtGasStationWithHerSister = 32;
		int remainingMilesWalkedByHiltsSisterAfterHiltStoleTheCarAndDroveOn = milesToTheConcertVenue - milesDrivenUntilHiltStoppedAtGasStationWithHerSister;
		System.out.println(remainingMilesWalkedByHiltsSisterAfterHiltStoleTheCarAndDroveOn);

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int minutesHiltSpentCursingGodForSnow = 90;
		int minutesHiltSpentShovelingHisReplyToHerCurses = 45;
		int amountOfMinutesGodSpentLaughingOnSaturday = minutesHiltSpentCursingGodForSnow + minutesHiltSpentShovelingHisReplyToHerCurses;
		System.out.println(amountOfMinutesGodSpentLaughingOnSaturday);


        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		double hotDogsBoughtByHilt = 6.0;
		double costPerHotDog = 0.5;
		double hiltsBillAtThePuppyMill = hotDogsBoughtByHilt * costPerHotDog;
		System.out.println(hiltsBillAtThePuppyMill);

        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int theMoneyHiltsPoorChoicesHaveLeftHerWith = 50;
		int priceOfAPencil = 7;
		int pencilsHiltCanBuyToBurnToKeepWarmAfterHerHeatGotCutOff = theMoneyHiltsPoorChoicesHaveLeftHerWith / priceOfAPencil;
		System.out.println(pencilsHiltCanBuyToBurnToKeepWarmAfterHerHeatGotCutOff);


        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int allButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = allButterflies - orangeButterflies;
		System.out.println(redButterflies);


        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double moneyTendered = 1.00;
		double candyPrice = 0.54;
		double changeOwed = moneyTendered - candyPrice;
		System.out.println(changeOwed);


        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int marksTrees = 13;
		int marksSaplings = 12;
		int futureTreesInMarksYard = marksTrees + marksSaplings;
		System.out.println(futureTreesInMarksYard);

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int hoursInADay = 24;
		int daysUntilJoyVisitsGrandma = 2;
		int hoursUntilJoyBringsGrandmaJoy = hoursInADay * daysUntilJoyVisitsGrandma;
		System.out.println(hoursUntilJoyBringsGrandmaJoy);


        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberOfKimsCousins = 4;
		int piecesOfGumPerCousin = 5;
		int amountOfGumKimWillBring = numberOfKimsCousins * piecesOfGumPerCousin;
		System.out.println(amountOfGumKimWillBring);


        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double moneyBroughtToTheStore = 3.00;
		double moneySpentOnCandy = 1.00;
		double dansRemainingAllowance = moneyBroughtToTheStore - moneySpentOnCandy;
		System.out.println(dansRemainingAllowance);



        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsInTheLake = 5;
		int peoplePerBoat = 3;
		int allPeopleOnTheLake = boatsInTheLake * peoplePerBoat;
		System.out.println(allPeopleOnTheLake);


        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellensLegoCollection = 380;
		int lostLegos = 57;
		int legosAvailablePresently = ellensLegoCollection - lostLegos;
		System.out.println(legosAvailablePresently);


        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int muffinsPreviouslyBaked = 35;
		int arthursMuffinGoal = 83;
		int muffinsToBakeToReachGoal = arthursMuffinGoal - muffinsPreviouslyBaked;
		System.out.println(muffinsToBakeToReachGoal);


        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willsNumberOfCrayons = 1400;
		int lucysNumberOfCrayons = 290;
		int willsExcessOfCrayonsComparedToLucy = willsNumberOfCrayons - lucysNumberOfCrayons;
		System.out.println(willsExcessOfCrayonsComparedToLucy);


        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage = 10;
		int stickerPagesOwned = 22;
		int myStickerCount = stickersPerPage * stickerPagesOwned;
		System.out.println(myStickerCount);


        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double cupcakesToShare = 100;
		double childrenSharingCupcakes = 8;
		double cupcakesPerChild = cupcakesToShare / childrenSharingCupcakes;
		System.out.println(cupcakesPerChild);


        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int gingerbreadCookiesToShare = 47;
		int cookiesPerJar = 6;
		int remainingCookiesAfterSharing = gingerbreadCookiesToShare%cookiesPerJar;
		System.out.println(remainingCookiesAfterSharing);


        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int croissantsBaked = 59;
		int neighborsToShareWith = 8;
		int croissantsRemainingAfterSharing = croissantsBaked%neighborsToShareWith;
		System.out.println(croissantsRemainingAfterSharing);


        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int cookiesOnOneTray = 12;
		int cookieMassProductionGoal = 276;
		int traysNeededToBecomeTheHenryFordOfCookies = cookieMassProductionGoal / cookiesOnOneTray;
		System.out.println(traysNeededToBecomeTheHenryFordOfCookies);


        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int pretzelsInBatch = 480;
		int pretzelsInServing = 12;
		int pretzelServingsPrepared = pretzelsInBatch/pretzelsInServing;
		System.out.println(pretzelServingsPrepared);


        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int lemonCupCakesAvailableToDistribute = 51;
		int cupcakesPerBox = 3;
		int boxesOfCupcakesGivenAway = lemonCupCakesAvailableToDistribute/cupcakesPerBox;
		System.out.println(boxesOfCupcakesGivenAway);


        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		// genuinely scratching my head on this one. who the hell has a family of 12 eating carrot sticks for breaky..
		int carrotSticksForBreakfast = 74;
		int childrenEatingCarrotSticksForBreakfast = 12;
		int carrotSticksLeftOverAfterBreakfast = carrotSticksForBreakfast%childrenEatingCarrotSticksForBreakfast;
		System.out.println(carrotSticksForBreakfast);


        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int teddyBearsInTheHouse = 98;
		int teddyBearsPerShelf = 7;
		int shelvesFilledWithBears = teddyBearsInTheHouse/teddyBearsPerShelf;
		System.out.println(shelvesFilledWithBears);


        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int numberOfPictures = 480;
		int albumCapacity = 20;
		int albumsNeededToStoreAllPics = numberOfPictures / albumCapacity;
		System.out.println(albumsNeededToStoreAllPics);


        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int skippedVariable = 1;

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int booksToBeOrganized = 210;
		int shelvesAvailable = 10;
		int booksContainedPerShelf = booksToBeOrganized/shelvesAvailable;
		System.out.println(booksContainedPerShelf);


        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int fourthToLast = 4;

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
     	int thirdToLast = 3;

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		int secondToLast = 2;

	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		int lastVariable = 2;
	}

}
