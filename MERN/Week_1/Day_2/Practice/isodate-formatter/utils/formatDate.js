import dayjs from "dayjs";
import relativeTime from 'dayjs/plugin/relativeTime.js';
dayjs.extend(relativeTime)

const formaData=(date)=>dayjs(date).format('MMM D, YYYY , h:mm:ss A ');
const dateFromNow=(date)=>dayjs(date).fromNow()
const formatDate = (date) => dayjs(date).format('dddd, MMMM DD, YYYY');
const formatDate1 = (date) => dayjs(date).format('MM/DD/YYYY');
export{formaData,dateFromNow,formatDate1,formatDate}
