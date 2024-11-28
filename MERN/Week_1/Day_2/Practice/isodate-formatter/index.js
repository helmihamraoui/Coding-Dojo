import {formaData,dateFromNow,formatDate1,formatDate} from "./utils/formatDate.js";
import chalk from "chalk";

console.log(chalk.blue("Long dates:"))
console.log(formaData("2023-01-01T12:34:56Z"));
console.log(formaData("2024-01-04T12:34:56Z"));
console.log(formaData("2023-12-08T12:34:56Z"));
console.log(formaData("2022-09-05T13:34:56Z"));
console.log(formaData("2019-10-02T11:55:56Z"));


console.log(chalk.red("relative dates:"))
console.log(dateFromNow('2023-01-01T12:34:56Z'));
console.log(dateFromNow("2024-01-04T12:34:56Z"));
console.log(dateFromNow("2023-12-08T12:34:56Z"));
console.log(dateFromNow("2022-09-05T13:34:56Z"));
console.log(dateFromNow("2019-10-02T11:55:56Z"));


console.log(chalk.green("longer dates:"))
console.log(formatDate('2023-01-01T12:34:56Z'));
console.log(formatDate("2024-01-04T12:34:56Z"));
console.log(formatDate("2023-12-08T12:34:56Z"));
console.log(formatDate("2022-09-05T13:34:56Z"));
console.log(formatDate("2019-10-02T11:55:56Z"));


console.log(chalk.yellow("short dates:"))
console.log(formatDate1('2023-01-01T12:34:56Z'));
console.log(formatDate1("2024-01-04T12:34:56Z"));
console.log(formatDate1("2023-12-08T12:34:56Z"));
console.log(formatDate1("2022-09-05T13:34:56Z"));
console.log(formatDate1("2019-10-02T11:55:56Z"));

