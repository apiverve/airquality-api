from setuptools import setup, find_packages

setup(
    name='apiverve_airquality',
    version='1.2.4',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Air Quality is an air pollution API that reports particulate pollution levels and health recommendations for any city or zip code. Look up PM2.5 and PM10 concentrations to check current air conditions; paid plans add ozone, toxic gases, EPA and DEFRA index scores, and an estimated 0-500 US AQI with its category and dominant pollutant.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/airquality?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
