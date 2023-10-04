// Open actuator/metrics/http.server.requests page, insert this script into browser console
let endpointData = [];
let currentUrl = getCurrentUrl();

function getCurrentUrl() {
    const urlObject = window.location.href;
    return urlObject.match(/^(https?:\/\/[^/]+\/[^/]+)/)[1];
}

async function getAverageTime(endpointUrl) {
    try {
        const response = await fetch(endpointUrl);
        const data = await response.json();
        const totalTime = data.measurements.find((metric) => metric.statistic === 'TOTAL_TIME').value;
        const count = data.measurements.find((metric) => metric.statistic === 'COUNT').value;
        const averageTime = totalTime / count;
        endpointData.push({endpointUrl, averageTime});
    } catch (e) {
    }
}

async function getEndpointPaths() {
    const response = await fetch(window.location.href);
    const data = await response.json();
    return data.availableTags[2].values;
}

function printSlowEndpoints() {
    console.log(`TOP 20 SLOWEST ENDPOINTS:`)
    endpointData.sort((a, b) => b.averageTime - a.averageTime);
    for (let i = 0; i < 20 && i < endpointData.length; i++) {
        const { endpointUrl, averageTime } = endpointData[i];
        console.log(`Average time = ${averageTime.toFixed(2)} seconds; Endpoint - ${endpointUrl} `);
    }
}

let endpointPaths = await getEndpointPaths();
for (let endpointPath of endpointPaths) {
    let encodedPath = encodeURI(endpointPath);
    let endpointMetricsUrl = `${currentUrl}/actuator/metrics/http.server.requests?tag=uri:${encodedPath}`;
    await getAverageTime(endpointMetricsUrl)
}
printSlowEndpoints();
