# -*- coding:utf-8 -*-
import os
import json


def load_json_file(json_file):
    """
    load json file
    """
    with open(json_file, encoding='utf-8') as data_file:
        json_content = json.load(data_file)
    return json_content

# get file path
pa = os.path.dirname(os.path.realpath(__file__))
