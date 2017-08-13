package package com.ankamagames.dofus.network.messages.game.atlas;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.AtlasPointsInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AtlasPointInformationsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5956;
    private boolean _isInitialized = false;
    private AtlasPointsInformations type = ;
    private FuncTree _typetree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5956;
    }

    public AtlasPointInformationsMessage initAtlasPointInformationsMessage(AtlasPointsInformations param1) {
         this.type = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.type = new AtlasPointsInformations();
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
         this.serializeAs_AtlasPointInformationsMessage(param1);
    }

    public void serializeAs_AtlasPointInformationsMessage(ICustomDataOutput param1) {
         this.type.serializeAs_AtlasPointsInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AtlasPointInformationsMessage(param1);
    }

    public void deserializeAs_AtlasPointInformationsMessage(ICustomDataInput param1) {
         this.type = new AtlasPointsInformations();
         this.type.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AtlasPointInformationsMessage(param1);
    }

    public void deserializeAsyncAs_AtlasPointInformationsMessage(FuncTree param1) {
         this._typetree = param1.addChild(this._typetreeFunc);
    }

    private void _typetreeFunc(ICustomDataInput param1) {
         this.type = new AtlasPointsInformations();
         this.type.deserializeAsync(this._typetree);
    }

}