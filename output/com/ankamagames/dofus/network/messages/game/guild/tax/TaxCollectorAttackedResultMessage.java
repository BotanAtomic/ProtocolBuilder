package package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorBasicInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorAttackedResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5635;
    private boolean _isInitialized = false;
    private boolean deadOrAlive = false;
    private TaxCollectorBasicInformations basicInfos = ;
    private BasicGuildInformations guild = ;
    private FuncTree _basicInfostree = ;
    private FuncTree _guildtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5635;
    }

    public TaxCollectorAttackedResultMessage initTaxCollectorAttackedResultMessage(boolean param1,TaxCollectorBasicInformations  param2,BasicGuildInformations  param3) {
         this.deadOrAlive = param1;
         this.basicInfos = param2;
         this.guild = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.deadOrAlive = false;
         this.basicInfos = new TaxCollectorBasicInformations();
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
         this.serializeAs_TaxCollectorAttackedResultMessage(param1);
    }

    public void serializeAs_TaxCollectorAttackedResultMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.deadOrAlive);
         this.basicInfos.serializeAs_TaxCollectorBasicInformations(param1);
         this.guild.serializeAs_BasicGuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorAttackedResultMessage(param1);
    }

    public void deserializeAs_TaxCollectorAttackedResultMessage(ICustomDataInput param1) {
         this._deadOrAliveFunc(param1);
         this.basicInfos = new TaxCollectorBasicInformations();
         this.basicInfos.deserialize(param1);
         this.guild = new BasicGuildInformations();
         this.guild.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorAttackedResultMessage(param1);
    }

    public void deserializeAsyncAs_TaxCollectorAttackedResultMessage(FuncTree param1) {
         param1.addChild(this._deadOrAliveFunc);
         this._basicInfostree = param1.addChild(this._basicInfostreeFunc);
         this._guildtree = param1.addChild(this._guildtreeFunc);
    }

    private void _deadOrAliveFunc(ICustomDataInput param1) {
         this.deadOrAlive = param1.readBoolean();
    }

    private void _basicInfostreeFunc(ICustomDataInput param1) {
         this.basicInfos = new TaxCollectorBasicInformations();
         this.basicInfos.deserializeAsync(this._basicInfostree);
    }

    private void _guildtreeFunc(ICustomDataInput param1) {
         this.guild = new BasicGuildInformations();
         this.guild.deserializeAsync(this._guildtree);
    }

}