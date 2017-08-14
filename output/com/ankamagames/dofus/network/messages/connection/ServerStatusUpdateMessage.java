package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.connection.GameServerInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServerStatusUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public GameServerInformations server;
  private FuncTree _servertree;
  public static final int protocolId = 50;

  public void serialize(ICustomDataOutput param1) {
    this.server.serializeAs_GameServerInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.server = new GameServerInformations();
    this.server.deserialize(param1);
  }
}
