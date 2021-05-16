#include <nlohmann/json.hpp>
#include <fstream>
#include <iostream>

using json = nlohmann::json;

int main()
{
//	json j;
//	j["pi"] = 3.99999;
	json j = "{ \"happy\": true, \"pi\": 3.141 }"_json;
	
	std::ofstream jsonFile("json_test.json");
	
	jsonFile << j.dump(4) << std::endl;;
	
	return 0;
}