package package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectorySettings;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectorySettingsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5652;
    private boolean _isInitialized = false;
    private Vector.<JobCrafterDirectorySettings> craftersSettings = ;
    private FuncTree _craftersSettingstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5652;
    }

    public JobCrafterDirectorySettingsMessage initJobCrafterDirectorySettingsMessage(Vector.<JobCrafterDirectorySettings> param1) {
         this.craftersSettings = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.craftersSettings = new Vector.<JobCrafterDirectorySettings>();
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
         this.serializeAs_JobCrafterDirectorySettingsMessage(param1);
    }

    public void serializeAs_JobCrafterDirectorySettingsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.craftersSettings.length);
         int _loc2_ = 0;
         while(_loc2_ < this.craftersSettings.length)
            (this.craftersSettings[_loc2_] as JobCrafterDirectorySettings).serializeAs_JobCrafterDirectorySettings(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobCrafterDirectorySettingsMessage(param1);
    }

    public void deserializeAs_JobCrafterDirectorySettingsMessage(ICustomDataInput param1) {
         JobCrafterDirectorySettings _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new JobCrafterDirectorySettings();
            _loc4_.deserialize(param1);
            this.craftersSettings.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobCrafterDirectorySettingsMessage(param1);
    }

    public void deserializeAsyncAs_JobCrafterDirectorySettingsMessage(FuncTree param1) {
         this._craftersSettingstree = param1.addChild(this._craftersSettingstreeFunc);
    }

    private void _craftersSettingstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._craftersSettingstree.addChild(this._craftersSettingsFunc);
            _loc3_++;
    }

    private void _craftersSettingsFunc(ICustomDataInput param1) {
         JobCrafterDirectorySettings _loc2_ = new JobCrafterDirectorySettings();
         _loc2_.deserialize(param1);
         this.craftersSettings.push(_loc2_);
    }

}