"""Installation check"""

from strands import Agent, tool


@tool
def configuration_check() -> str:
    return "Configuration complete!"


agent = Agent(tools=[configuration_check])

agent("Please confirm if the configuration is complete")

print()
