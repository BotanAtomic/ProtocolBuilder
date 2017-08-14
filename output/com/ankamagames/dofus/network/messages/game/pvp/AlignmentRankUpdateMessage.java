package com.ankamagames.dofus.network.messages.game.pvp;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlignmentRankUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int alignmentRank = 0;
  public boolean verbose = false;
  public static final int protocolId = 6058;

  public void serialize(ICustomDataOutput param1) {
    if (this.alignmentRank < 0) {
      throw new Exception("Forbidden value (" + this.alignmentRank + ") on element alignmentRank.");
    }
    param1.writeByte(this.alignmentRank);
    param1.writeBoolean(this.verbose);
  }

  public void deserialize(ICustomDataInput param1) {
    this.alignmentRank = param1.readByte();
    if (this.alignmentRank < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.alignmentRank
              + ") on element of AlignmentRankUpdateMessage.alignmentRank.");
    }

    this.verbose = param1.readBoolean();
  }
}
