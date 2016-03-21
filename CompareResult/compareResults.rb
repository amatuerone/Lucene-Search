
require "rubygems"
require "csv"

$Query1 = []
$Query2 = []
$Query3 = []
$Query4 = []

$LQuery = []
$LQuery2 = []
$LQuery3 = []
$LQuery4 = []

def compare()
	f = File.open("results.eval", "r")
	while !f.eof
		inputLine = f.readline()
		inputTokens = inputLine.split(" ")
		if inputTokens[0].to_i.to_s == inputTokens[0]
			if inputTokens[0].strip == "1"
				$Query1.push(inputTokens[2])	
			end
			if inputTokens[0].strip == "2"
				$Query2.push(inputTokens[2])	
			end
			if inputTokens[0].strip == "3"
				$Query3.push(inputTokens[2])	
			end
			if inputTokens[0].strip == "4"
				$Query4.push(inputTokens[2])	
			end
		end
	end

	createResultListFromLucene()
	Analyse()
end

def createResultListFromLucene()
	workingDir = Dir.pwd
	dirTokens = workingDir.split("/")
	luceneDir = dirTokens[0..dirTokens.length-2].join("/")+"/Lucene-Homework"

	[1,2,3,4].each do |item|
		lResult = File.open(luceneDir+"/query"+item.to_s+".txt")

		while !lResult.eof
			result = lResult.readline().strip			
			if result.length!=0
			    r = result.split("-") 
			    if r.count > 1
			    	$LQuery.push(r[1].split(".")[0])		
			    end
				
			end
			
		end
	end
end


def Analyse()
	workingDir = Dir.pwd

	puts"	query1Match  " 
	puts	query1Match.count 
	puts"	query2Match  "
	puts	query2Match.count 
	puts"	query3Match  "
	puts	query3Match.count 
	puts"	query4Match  "
	puts	query4Match.count 
	csv1 =  workingDir + "/common-docs.xls"

	CSV.open(csv1 , 'w' ) do |writer|
  	
    	writer << ["1", query1Match.count]
    	writer << ["2", query2Match.count]
    	writer << ["3", query3Match.count]
    	writer << ["4", query4Match.count]
	end  
end



compare()