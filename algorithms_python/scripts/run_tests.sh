cd ..
export PYTHONPATH=$PYTHONPATH:./src
python3 -m unittest discover -s tests -t . -v


# IMPORTANT NOTE: For python unittest discover argument:
# what you specify with -s, has to be contained in what you specify with -t.