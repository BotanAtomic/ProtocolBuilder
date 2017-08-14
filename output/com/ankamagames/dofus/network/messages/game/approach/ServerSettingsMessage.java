package com.ankamagames.dofus.network.messages.game.approach;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServerSettingsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String lang = "";
  public int community = 0;
  public int gameType = -1;
  public int arenaLeaveBanTime = 0;
  public static final int protocolId = 6340;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.lang);
    if (this.community < 0) {
      throw new Exception("Forbidden value (" + this.community + ") on element community.");
    }
    param1.writeByte(this.community);
    param1.writeByte(this.gameType);
    if (this.arenaLeaveBanTime < 0) {
      throw new Exception(
          "Forbidden value (" + this.arenaLeaveBanTime + ") on element arenaLeaveBanTime.");
    }
    param1.writeVarShort(this.arenaLeaveBanTime);
  }

  public void deserialize(ICustomDataInput param1) {
    this.lang = param1.readUTF();

    this.community = param1.readByte();
    if (this.community < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.community
              + ") on element of ServerSettingsMessage.community.");
    }

    this.gameType = param1.readByte();

    this.arenaLeaveBanTime = param1.readVarUhShort();
    if (this.arenaLeaveBanTime < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.arenaLeaveBanTime
              + ") on element of ServerSettingsMessage.arenaLeaveBanTime.");
    }
  }
}
