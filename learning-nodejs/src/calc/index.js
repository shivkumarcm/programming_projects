#!/usr/bin/env node
import yargs from "yargs"
import {hideBin} from "yargs/helpers";

const argv = yargs(hideBin(process.argv)).argv

yargs(hideBin(process.argv))
    .command({
        command: "add",
        describe: "Adds two given numbers",
        builder: {
            x: {
                describe: 'First argument',
                demandOption: true,
                type: 'number'
            },
            y: {
                describe: 'Second argument',
                demandOption: true,
                type: 'number'
            }
        },
        handler: function() {
            console.log(argv.x + argv.y)
        }
    })
    .command({
        command: "sub",
        describe: "Subtracts two given numbers",
        builder: {
            x: {
                describe: 'First argument',
                demandOption: true,
                type: 'number'
            },
            y: {
                describe: 'Second argument',
                demandOption: true,
                type: 'number'
            }
        },
        handler: function() {
            console.log(argv.x - argv.y)
        }
    })
    .command({
        command: "sqr",
        describe: "Square of the given number",
        builder: {
            x: {
                describe: 'Input argument',
                demandOption: true,
                type: 'number'
            }
        },
        handler: function() {
            console.log(argv.x * argv.x)
        }
    })
    .parse()
