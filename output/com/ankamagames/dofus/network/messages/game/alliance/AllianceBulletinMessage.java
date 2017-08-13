package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.dofus.network.messages.game.social.BulletinMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceBulletinMessage extends BulletinMessage implements INetworkMessage {

    private int protocolId = 6690;
    private boolean _isInitialized = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6690;
    }

    public AllianceBulletinMessage initAllianceBulletinMessage(String param1,int  param2,Number  param3,String  param4,int  param5) {
         super.initBulletinMessage(param1,param2,param3,param4,param5);
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
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
         this.serializeAs_AllianceBulletinMessage(param1);
    }

    public void serializeAs_AllianceBulletinMessage(ICustomDataOutput param1) {
         super.serializeAs_BulletinMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceBulletinMessage(param1);
    }

    public void deserializeAs_AllianceBulletinMessage(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceBulletinMessage(param1);
    }

    public void deserializeAsyncAs_AllianceBulletinMessage(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}