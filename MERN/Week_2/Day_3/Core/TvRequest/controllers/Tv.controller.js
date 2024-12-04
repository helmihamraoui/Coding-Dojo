    import tvShows from '../modules/Tv.module.js';

    const tvController = {
        getAllShows: (req, res) => {
        res.json(tvShows);
    },
    getShowsByYear: (req, res) => {
        const year = parseInt(req.params.year);
		const getByYear = tvShows.filter((show) => show.yearCreated === year);
		res.json(getByYear);
    },
    deleteShowByTitle: (req, res) => {
        const deleteShow = req.params.title;
		const title = tvShows.findIndex((show) => show.tvShow == deleteShow);
		tvShows.splice(title, 1);
		res.json(tvShows);
    },
    
    updateStarring: (req, res) => {
        tvShows.forEach((show) => {
			if (show.tvShow == req.params.title) {
				show.starring = req.body.starring;
			}
		});
		const updatedTvShow = tvShows.find(
			(show) => show.tvShow == req.params.title
		);
		res.json(updatedTvShow);
	},
    
    addShow: (req, res) => {
        tvShows.push(req.body);
		res.json(tvShows);
    }
    };

    export default tvController;
