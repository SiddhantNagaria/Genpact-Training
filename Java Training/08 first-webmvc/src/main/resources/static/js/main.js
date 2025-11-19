import { cToF, fToC } from "./math.js";
import log from "./log.js";

document.getElementById('btnConverter').addEventListener('click'
	, () => {
		const input = document.getElementById('temp').value;
		const mode = document.getElementById('mode').value;

		let result;
		if (mode === 'cToF') {
			result = cToF(Number(input));
			log(`converted ${input} -> ${result} `);
		} else {
			result = fToC(Number(input));
			log(`converted ${input} -> ${result} `);
		}
		document.getElementById('output').textContent = "Result : " + result;
	})