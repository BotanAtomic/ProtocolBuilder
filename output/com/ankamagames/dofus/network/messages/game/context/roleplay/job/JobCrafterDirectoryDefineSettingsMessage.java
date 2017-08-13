package package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectorySettings;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryDefineSettingsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5649;
    private boolean _isInitialized = false;
    private JobCrafterDirectorySettings settings = ;
    private FuncTree _settingstree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5649;
    }

    public JobCrafterDirectoryDefineSettingsMessage initJobCrafterDirectoryDefineSettingsMessage(JobCrafterDirectorySettings param1) {
         this.settings = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.settings = new JobCrafterDirectorySettings();
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
         this.serializeAs_JobCrafterDirectoryDefineSettingsMessage(param1);
    }

    public void serializeAs_JobCrafterDirectoryDefineSettingsMessage(ICustomDataOutput param1) {
         this.settings.serializeAs_JobCrafterDirectorySettings(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobCrafterDirectoryDefineSettingsMessage(param1);
    }

    public void deserializeAs_JobCrafterDirectoryDefineSettingsMessage(ICustomDataInput param1) {
         this.settings = new JobCrafterDirectorySettings();
         this.settings.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobCrafterDirectoryDefineSettingsMessage(param1);
    }

    public void deserializeAsyncAs_JobCrafterDirectoryDefineSettingsMessage(FuncTree param1) {
         this._settingstree = param1.addChild(this._settingstreeFunc);
    }

    private void _settingstreeFunc(ICustomDataInput param1) {
         this.settings = new JobCrafterDirectorySettings();
         this.settings.deserializeAsync(this._settingstree);
    }

}