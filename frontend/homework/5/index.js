const http=require('http')
const path=require('path')
const fs=require('fs')
const os=require('os')
let details={}
/*
   This function creates an object of the System Information  
   @returns {object} All the required details in key value pairs
*/
function systemInformation()
{
    details={
    HostName: os.hostname(),
    OperatingSystem: os.platform(),
    Architecture: os.arch(),
    OSRelease: os.release(),
    Uptime: os.uptime(),
    NumberOfCPUCores: os.cpus().length,
    TotalMemory: os.totalmem(),
    FreeMemory: os.freemem(),
    CurrentWorkingDirectory: process.cwd()
    }
    return details;
}
systemInformation()
/*
   This function creates a path and writes content to the file at that path
   The value 4 is to convert the entire string in a human readable format 
*/
fs.writeFile(path.join(__dirname,'json.txt'), JSON.stringify(details,null,4), (err) => {
    if (err) {
        console.log(err)
    }
})

const filePath=path.join(__dirname,'json.txt')

/*
   This function fetches information from .txt file and uploads it to out http server.
   @param {req} request URL
   @param {res} sending back the response
   @returns {string} Information about our OS 
*/
const server=http.createServer((req,res)=>{
    if(req.url==='/'){
        fs.readFile(filePath,'utf8',(err,data)=>{
            if(err)
            console.log(err);
            else {
                console.log(data);
                res.writeHead(200, { 'Content-Type': 'text/html' });
                res.write('<h3>Hello , my name is Harsh</h3>');
                res.write('<h3>Here is my system information</h3>');
                res.end(`<div style="width:60% ; background-color:#dadada"><h4>${data}</h4></div>`);
            }
        })
        
    }
});
//Checks if port is present in environment variable then use that or else use 5100
const PORT=process.env.PORT||5100;
server.listen(PORT,()=>{
    console.log(`Server running on port ${PORT}`);
})

/*
   This function extracts file information from the filePath string 
   @param {string} filePath 
   @returns {object} file object with all information about the file
*/
function extractFileInfo(filePath)
{
    let fileObj={
        extension:path.extname(filePath),
        baseName:path.basename(filePath),
        directory:path.dirname(filePath)
    }
    return fileObj;
}

/*
   This function traverses over an array of file path and return objects for each
   @param {array} all file paths
   @returns {array} array of objects where each object contains information about that file path 
*/
function processFilePaths(allFilePaths)
{
    let extractAllPath=[];
    for(let filePath of allFilePaths)
    {
        extractAllPath.push(extractFileInfo(filePath));
    }
    return extractAllPath;

}

const filePaths = [

  'dir1/dir2/file1.txt',

  'dir1/dir3/file2.txt',

  'dir1/dir3/file3.md',

  'dir4/file4.jpg',

  'dir4/file5.pdf',

];
let extractAllPath=processFilePaths(filePaths)
//printing all file paths
for(let eachPath of extractAllPath)
{
    console.log(eachPath)
}