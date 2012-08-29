(function($) {

	// TODO: create IGLOO.preload() that uses IGLOO.Preloader() with alternative API?
	// e.g. IGLOO.preload(['img1.jpg,img2.jpg'], function(){  });

	/**
	 * TODO: [Preloader description]
	 * @constructor 			Builds a Preloader instance
	 * @param {String} id     	id of Preloader instance, used as part of event name in triggered events
	 * @param {Array}  images 	array of image paths to preload
	 * @requires 				jQuery, underscore.js
	 */
	function Preloader(id, images, options) {
		this.id 			= id;
		this.images 		= images;
		this.total 			= images.length;
		this.count 			= 0; 				// incremented as images are loaded

		this.config 		= $.extend({}, this.defaults, options || {});

		this.preload(images);
	}

	Preloader.prototype.defaults = {
		// TODO: any options to this? Maybe option to pass in complete callback fn?
	};

	Preloader.prototype.preload = function(images) {
		var self = this;
		_.each(images, function(path) {
			console.log('preloading:', path);
			$('<img>').attr('src', path).one(
				'load',
				function(e) {
					self.count++;
					self.fireEvent('progress');
					self.isComplete() && self.fireEvent('complete');
				}
			);
		});
	};

	Preloader.prototype.isComplete = function() {
		return this.count === this.total;
	};

	Preloader.prototype.getProgress = function() {
		return this.count / this.total;
	};

	Preloader.prototype.fireEvent = function(name) {
		$(window).trigger('Preloader:' + name, this);
	};

	window.IGLOO = window.IGLOO || {};
	window.IGLOO.Preloader = Preloader;

}(jQuery));