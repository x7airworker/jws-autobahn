# JavaWebStack Autobahn

This project uses the [Autobahn test suite](https://github.com/crossbario/autobahn-testsuite) to run tests against the JavaWebStack [HTTP-Client](https://github.com/JavaWebStack/http-client) and verifies the WebSocket implementation.  
Disclaimer: This is just a simple project to help with debugging and fixing errors. It will help us to integrate the functionality into JUnit tests of the HTTP-Client.

## Docker
```shell
docker run -it --rm \
    -v "${PWD}/config:/config" \
    -v "${PWD}/reports:/reports" \
    -p 9001:9001 \
    --name fuzzingserver \
    crossbario/autobahn-testsuite
```

## Autobahn Config (fuzzingserver.json)
```json
{
    "url": "ws://127.0.0.1:9001",
    "outdir": "./reports/clients",
    "cases": ["*"],
    "exclude-cases": [
        "9.*",
        "12.*",
        "13.*"
    ],
    "exclude-agent-cases": {}
}

```