"""Basic local MCP client"""

from mcp import stdio_client, StdioServerParameters
from strands import Agent
from strands.tools.mcp import MCPClient

stdio_mcp_client = MCPClient(
    lambda: stdio_client(StdioServerParameters(command="python", args=["math_fastmcp_server.py"]))
)

with stdio_mcp_client:
    tools = stdio_mcp_client.list_tools_sync()
    agent = Agent(tools=tools)

    agent("What is the secant squared of 1.4?")
