package com.ankamagames.dofus.network.messages.game.atlas.compass;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.MapCoordinates;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class CompassUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int type = 0;
  public MapCoordinates coords;
  private FuncTree _coordstree;
  public static final int protocolId = 5591;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.type);
    param1.writeShort(this.coords.getTypeId());
    this.coords.serialize(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.type = param1.readByte();
    if (this.type < 0) {
      throw new Error("Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
    }

    int _loc2_ = param1.readUnsignedShort();
    this.coords = ProtocolTypeManager.getInstance(MapCoordinates, _loc2_);
    this.coords.deserialize(param1);
  }
}
