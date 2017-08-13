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


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5591;
    }

    public CompassUpdateMessage initCompassUpdateMessage(int param1,MapCoordinates  param2) {
         this.type = param1;
         this.coords = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.type = 0;
         this.coords = new MapCoordinates();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CompassUpdateMessage(param1);
    }

    public void serializeAs_CompassUpdateMessage(ICustomDataOutput param1) {
         param1.writeByte(this.type);
         param1.writeShort(this.coords.getTypeId());
         this.coords.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CompassUpdateMessage(param1);
    }

    public void deserializeAs_CompassUpdateMessage(ICustomDataInput param1) {
         this._typeFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.coords = ProtocolTypeManager.getInstance(MapCoordinates,_loc2_);
         this.coords.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CompassUpdateMessage(param1);
    }

    public void deserializeAsyncAs_CompassUpdateMessage(FuncTree param1) {
         param1.addChild(this._typeFunc);
         this._coordstree = param1.addChild(this._coordstreeFunc);
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of CompassUpdateMessage.type.");
         }
    }

    private void _coordstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.coords = ProtocolTypeManager.getInstance(MapCoordinates,_loc2_);
         this.coords.deserializeAsync(this._coordstree);
    }

}