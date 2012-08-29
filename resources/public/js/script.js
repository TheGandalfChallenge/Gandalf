(function($) {

	/**
	 * Day Number
	 * Number of business days since the start date.
	 * TEMPORARY SOLUTION, YEAH MAN!
	 * @type {Number}
	 */
	var DAY_NUMBER = 15;

	/**
	 * Path to photo images
	 * @type {String}
	 */
	var PHOTO_PATH = '/photos/{name}/{day}.jpg';

	/**
	 * Player names that correspond to /photos/[name] directories
	 * and img[id] value for players
	 * @type {Array}
	 */
	var players = [
		'aaron',
		'jay',
		'rob',
		'pete',
		'vic'
	];

	/**
	 * Generates an array of photo paths for a given player.
	 * This array is passed to $.fn.iskip()
	 * @param  {String} name 	Player name
	 * @return {Array}      	Array of photo paths e.g. ['/photos/vic/001.jpg','/photos/vic/002.jpg']
	 */
	var getPhotoArray = function(name) {
		var photos = [];
		for (var i = 1; i <= DAY_NUMBER; i++) {
			photos.push( getPhotoPath(name, i) );
		};
		return photos;
	};

	/**
	 * Builds a full photo path from given player name and day number.
	 * Photo filenames will be 3 chars e.g. 1 > '001.jpg'
	 * @param  {String} name Player name
	 * @param  {Number} num  Day number
	 * @return {String}      Full path to photo image
	 */
	var getPhotoPath = function(name, num) {
		var day 	= num.toString(),
			size 	= 3;
		while (day.length < 3) {
			day = '0' + day;
		}
		return PHOTO_PATH.replace(/{day}/, day).replace(/{name}/, name);
	};

	/**
	 * Init iSkip for each player
	 */
	_.each(players, function(name){
		$( '#' + name ).iskip({
			images: getPhotoArray(name),
			method: 'mousemove'
		});
	});

}(jQuery));