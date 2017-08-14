package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectorySettings;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryDefineSettingsMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public JobCrafterDirectorySettings settings;
  private FuncTree _settingstree;
  public static final int protocolId = 5649;

  public void serialize(ICustomDataOutput param1) {
    this.settings.serializeAs_JobCrafterDirectorySettings(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.settings = new JobCrafterDirectorySettings();
    this.settings.deserialize(param1);
  }
}
