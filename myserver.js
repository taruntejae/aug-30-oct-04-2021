const app = require('express')();
app.get('/now', (req, res) => {
	res.end(`It's ${new Date()}`);
});
app.listen(8080);