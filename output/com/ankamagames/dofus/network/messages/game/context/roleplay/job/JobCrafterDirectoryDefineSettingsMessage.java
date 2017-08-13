package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

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
    private JobCrafterDirectorySettings settings;
    private FuncTree _settingstree;


    public void serialize(ICustomDataOutput param1) {
         this.settings.serializeAs_JobCrafterDirectorySettings(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.settings = new JobCrafterDirectorySettings();
         this.settings.deserialize(param1);
    }

}