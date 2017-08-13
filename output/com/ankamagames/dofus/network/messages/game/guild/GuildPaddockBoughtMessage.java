package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockContentInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildPaddockBoughtMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5952;
    private boolean _isInitialized = false;
    private PaddockContentInformations paddockInfo = ;
    private FuncTree _paddockInfotree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5952;
    }

    public GuildPaddockBoughtMessage initGuildPaddockBoughtMessage(PaddockContentInformations param1) {
         this.paddockInfo = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.paddockInfo = new PaddockContentInformations();
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
         this.serializeAs_GuildPaddockBoughtMessage(param1);
    }

    public void serializeAs_GuildPaddockBoughtMessage(ICustomDataOutput param1) {
         this.paddockInfo.serializeAs_PaddockContentInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildPaddockBoughtMessage(param1);
    }

    public void deserializeAs_GuildPaddockBoughtMessage(ICustomDataInput param1) {
         this.paddockInfo = new PaddockContentInformations();
         this.paddockInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildPaddockBoughtMessage(param1);
    }

    public void deserializeAsyncAs_GuildPaddockBoughtMessage(FuncTree param1) {
         this._paddockInfotree = param1.addChild(this._paddockInfotreeFunc);
    }

    private void _paddockInfotreeFunc(ICustomDataInput param1) {
         this.paddockInfo = new PaddockContentInformations();
         this.paddockInfo.deserializeAsync(this._paddockInfotree);
    }

}