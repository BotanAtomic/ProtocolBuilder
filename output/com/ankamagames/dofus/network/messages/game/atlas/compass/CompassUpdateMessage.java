package com.ankamagames.dofus.network.messages.game.atlas.compass;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.MapCoordinates;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class CompassUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5591;
    private boolean _isInitialized = false;
    private int type = 0;
    private MapCoordinates coords;
    private FuncTree _coordstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.type);
         param1.writeShort(this.coords.getTypeId());
         this.coords.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of CompassUpdateMessage.type.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.coords = ProtocolTypeManager.getInstance(MapCoordinates,_loc2_);
         this.coords.deserialize(param1);
    }

}